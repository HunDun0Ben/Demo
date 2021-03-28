#!/bin/bash
RED="\033[4;31m"
GREEN="\033[1;32m"
YELLOW="\033[1;33m"

C_RESET="\033[0m"

start_sh(){
  echo -e "${GREEN}prepare merge video ana audio...${C_RESET}"
}

start_sh
resource_path=""
output_path=""
# f - file 源文件所在的目录
# o - output 输出目录
analysisOpt(){
  echo "function analysisOpt parameter is:"${*}
  # getopts 是等于处理函数内容只是帮忙完成了函数的转换
  while getopts ":f:o:m:" OPT; do
    case $OPT in
    f) resource_path=$OPTARG;;
    o) output_path=$OPTARG;;
    m) filename=$OPTARG;;
    esac
  done
}
analysisOpt "$@"

error_list=()
if [ -d ${resource_path} ];then
  echo "Resource Path is $resource_path.";
else
  error_list[${#error_list[*]}]="Can't have ${RED}Resource${C_RESET} file path."
fi

if [ -d ${output_path} ]; then
    echo "Output Path is $output_path。"
else
  error_list[${#error_list[*]}]="${YELLOW}Can't have ${RED}Dist${C_RESET} ${YELLOW}file path.${C_RESET}"
fi

error_flag=false;
for msg in "${error_list[*]}"
do
  error_flag=true;
  echo -e "\a"$msg;
done
if ${erro_flag}; then
    exit 1;
fi
# 指向视频文件
video_f=""
# 指向音频文件
audio_f=""






















