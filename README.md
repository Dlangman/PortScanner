# PortScanner
- 使用Java实现的端口扫描，打包成jar包后可在命令行中运行

## 技术特点

- 模块化，代码易读
- 使用字符串分割
- 同步、抢占式多线程
- map存储端口号与协议对应信息

## 使用方法

- 支持查询C段ip后主机和端口段
- 启动后，可输入：
- - 192.168.1.1 80 （代表扫描ip为192.168.1.1的80端口）
- - 192.168.1.1-80 80 （代表扫描ip为192.168.1.1至192.168.1.80的80端口）
- - 192.168.1.1 0-1000 （代表扫描ip为192.168.1.1的0-1000端口）
- - 192.168.1.1-80 0-1000 （代表扫描ip为192.168.1.1至192.168.1.80的-1000端口）

## 后记

- fork后可自己编写图形界面，仅需一个输入框和输出框即可
- 代码简陋，还望大佬们帮忙斧正，有疑问可Issues上提交或私聊交流
