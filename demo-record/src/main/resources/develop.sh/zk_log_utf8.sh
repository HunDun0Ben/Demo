#!/bin/bash

zk_env=$(env | grep -w ZK_HOME)
## -z 判断字符串变量是否为空
if [ -z "$zk_env" ]; then
    echo "请先配置环境变量 \$ZK_HOME"
fi
