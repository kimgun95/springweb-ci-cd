# springweb [![Build Status](https://app.travis-ci.com/kimgun95/springweb.svg?branch=master)](https://app.travis-ci.com/kimgun95/springweb)

[웹 서비스 출시하기 정리글](https://obtainable-poppyseed-72e.notion.site/e4dff969a71e41b0a3a7f3952f0da8c5)
### 서비스 구조
![서비스전체구조](https://user-images.githubusercontent.com/54833128/212687110-c9124a11-4256-4105-86ac-3c6b70fa5caf.png)
- SpringBoot, JPA로 API 구현
- AWS EC2 & RDS
- TravisCI & S3 & AWS CodeDeploy로 CI/CD
- Nginx를 활용한 무중단 배포
- 도메인 생성, HTTPS 연결

### 이슈 발생 및 해결
- database
    - [profile include & SQL connection Exception(01.03)](https://obtainable-poppyseed-72e.notion.site/profile-include-SQL-connection-Exception-a610f6ddd52749c8b4898c79a7bdbf18)
    - [Too many connections & connection refused(01.04)](https://obtainable-poppyseed-72e.notion.site/Too-many-connections-connection-refused-6ba6802df0a24c258ba8099e845e7156)  
        -> [MySQL의 timeout(01.16)](https://obtainable-poppyseed-72e.notion.site/MySQL-time-out-59efb3d6d5c34cd38f0025ef53f3529d)
- Nginx
    - [도메인 구매 후 connection refused(01.09)](https://obtainable-poppyseed-72e.notion.site/connection-refused-144e4bf81ffe4a62b3938e52be4c260a)  
        -> [무중단 배포 전략, reverse proxy(01.17)](https://obtainable-poppyseed-72e.notion.site/reverse-proxy-e62b4b3b1624411fa2d0b3d36c46c296)
- CI/CD
    - [error in opening zip file(01.16)](https://obtainable-poppyseed-72e.notion.site/error-in-opening-zip-file-d30399462ff540f3b6a659ae49ca29d8)


### 해당 기술 사용 이유, 더 좋은 방법은 없었을까?
- [nginx -t, kill -9 사용 이유(01.11)](https://obtainable-poppyseed-72e.notion.site/nginx-t-kill-9-shutdown-hook-b99cc67f88aa43fc94012c64ee522591)
- [AWS 클라우드, MariaDB 선택 이유(01.12)](https://obtainable-poppyseed-72e.notion.site/AWS-MariaDB-11c8ce9e13b54587b343d5eec822b152)
- [Java 8 선택 이유](https://obtainable-poppyseed-72e.notion.site/Java-8-ca65a4857b804b589f4e757c37cf9fdb)
