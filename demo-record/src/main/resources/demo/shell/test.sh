#!/bin/bash
# 字体颜色
RED="\033[4;31m"
GREEN="\033[1;32m"
YELLOW="\033[1;33m"
# 重置
C_RESET="\033[0m"

### 全局变量 ###
resource_path=""  # 源文件基础路径
output_path=""    # 输出文件路径
name_prefix=""    # 输出文件基本名称

index=0
###############


# 显示启动 banner
start_banner() {
  echo -e "${GREEN}****************************************"
  echo -e "${GREEN}**${YELLOW}prepare merge video ana audio to mp4${GREEN}**"
  echo -e "${GREEN}****************************************${C_RESET}"
}

analysisOpt() {
  # getopts 是等于一个函数帮你处理了参数，完成了短名的转换
  while getopts ":f:o:m:" OPT; do
    case $OPT in
    # f - file 源文件所在的目录
    f) resource_path=$OPTARG ;;
    # o - output 输出目录
    o) output_path=$OPTARG ;;
    # m - 生成的文件名称前缀
    m) name_prefix=$OPTARG ;;
    *) ;;
    esac
  done
}
# 打印banner
start_banner
# 解析参数
analysisOpt "$@"

# 错误信息 List
error_list=()
# 空字符串为 0, Shell 中 0 为 true，其他值为 false
if [[ "x${resource_path}" != "x" ]] && [ -d ${resource_path} ]; then
  echo -e "Resource Path is ${GREEN}$resource_path${C_RESET}"
else
  error_list[${#error_list[*]}]="${YELLOW}Need '-f' provider ${RED}Resource${C_RESET} ${YELLOW}legal file path.${C_RESET}"
fi

if [[ "x${output_path}" != "x" ]] && [ -d ${output_path} ]; then
  echo -e "Output Path is ${GREEN}$output_path${C_RESET}"
else
  error_list[${#error_list[*]}]="${YELLOW}Need '-o' provider ${RED}Dist${C_RESET} ${YELLOW}legal file path.${C_RESET}"
fi

# 判断参数有误的话，提前退出。并打印错误消息
# ben-todo: 修改成判断list大小
error_flag=false
for msg in "${error_list[@]}"; do
  error_flag=true
  echo -e $msg
done

if [[ "$error_flag" == "true" ]]; then
  echo -e "Error! exit!"
  exit 1
fi

# 判断是否是叶子目录
function isLeaf() {
  # 计算该路径下的目录数
  rc=`ls -l $1|grep '^d'|wc -l`
  echo $rc
}

# 获取音频文件全路径
function getAudioFilePath(){
  local file=`ls $1 | grep audio.m4s`
  echo "$1/$file"
}

# 获取视频文件全路径
function getVideoFilePath(){
  local file=`ls $1 | grep video.m4s`
  echo "$1/$file"
}

# 根据路径生成对应文件
function fileRound(){
  # 先判断当前目录是不是叶子目录
  flag=$(isLeaf $1)
  if [ $flag -eq 0 ]; then
    local audio_f=`getAudioFilePath $path`
    local video_f=`getVideoFilePath $path`
    # echo "input file is :"$(basename $audio_f) $(basename $video_f)
    index=`expr ${index} + 1`
    local final_name="$output_path/${name_prefix}_${index}"
    echo "output file name is : ${final_name}"
    # 调用 ffmpeg 生成最后的文件
    ffmpeg -i $audio_f -i $video_f ${final_name}
  else
    # 遍历文件
    for file in `ls $1`
    do
      [[ -e "$file" ]] || break # handle the case of no file
      local path="$1/$file"
      if [ -d $path ]; then
        fileRound $path
      fi
    done
  fi

}
fileRound $resource_path
