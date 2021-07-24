#通过挂载目录分别以配置文件启动redis
docker run -p 6379:6379 --name redis6379 -v C:/Users/rongh/Desktop/geek/src/cn/geek/git/main/week12/zrh/redis6379.conf:/etc/redis/redis6379.conf -v C:/Users/rongh/Desktop/geek/src/cn/geek/git/main/week12/zrh/redis0:/data -d redis redis-server /etc/redis/redis6379.conf --appendonly yes
docker run -p 6380:6380 --name redis6380 -v C:/Users/rongh/Desktop/geek/src/cn/geek/git/main/week12/zrh/redis6380.conf:/etc/redis/redis6380.conf -v C:/Users/rongh/Desktop/geek/src/cn/geek/git/main/week12/zrh/redis1:/data -d redis redis-server /etc/redis/redis6380.conf --appendonly yes

#6379
redis-cli
#6380
redis-cli -p 6380

#由于使用docker，需使用容器内网ip 
#先使用以下命令查看主服务器内网ip,cb09c8508db2为容器id，docker ps查看
docker inspect containerid cb09c8508db2

#主服务器ip为172.17.0.2
slaveof 172.17.0.2 6379

