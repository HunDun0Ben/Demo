#!/bin/bash
RED="\033[4;31m"
GREEN="\033[1;32m"
YELLOW="\033[1;33m"

C_RESET="\033[0m"

# 显示启动 banner
start_banner() {
  echo -e "${YELLOW}prepare merge video ana audio...${C_RESET}"
}

resource_path=""
output_path=""
filename=""

analysisOpt() {
  # getopts 是等于处理函数内容只是帮忙完成了函数的转换
  while getopts ":f:o:m:" OPT; do
    case $OPT in
    # f - file 源文件所在的目录
    f) resource_path=$OPTARG ;;
    # o - output 输出目录
    o) output_path=$OPTARG ;;
    # m - 生成的文件名称前缀
    m) filename=$OPTARG ;;
    esac
  done
}
start_banner
analysisOpt "$@"

# 错误信息 List
error_list=()
# 空字符串为 0, Shell 中 0 为 true，其他值为 false
if [[ "x${resource_path}" != "x" ]] && [ -d ${resource_path} ]; then
  echo -e "Resource Path is ${GREEN}$resource_path${C_RESET}."
else
  error_list[${#error_list[*]}]="${YELLOW}Need '-f' provider ${RED}Resource${C_RESET} ${YELLOW}file path.${C_RESET}"
fi

if [[ "x${output_path}" != "x" ]] && [ -d ${output_path} ]; then
  echo -e "Output Path is ${GREEN}$output_path${C_RESET}。"
else
  error_list[${#error_list[*]}]="${YELLOW}Need '-o' provider ${RED}Dist${C_RESET} ${YELLOW}file path.${C_RESET}"
fi

error_flag=false
for msg in "${error_list[@]}"; do
  error_flag=true
  echo -e $msg
done
# 不符合要求，错误推出 shell
if [[ "$error_flag" == "true" ]]; then
  echo -e "Error! exit!"
  exit 1
fi

# 遍历文件


# 指向视频文件
video_f=""
# 指向音频文件
audio_f=""
