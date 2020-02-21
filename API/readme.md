# 설정 방법
로컬환경에서 실행 후 http://127.0.0.1:9090/doc-talk/login으로 접속
id : test@test.com
password : 1234

# Doctalk API & Front
이 프로젝트의 목적은 Doctalk 웹의 데이터를 반환하는 RESTFul API를 만들고 Front js를 활용해서 UI를 만드는 것 입니다.

전달되는 앱의 형태를 확인하여 DB 구조를 직접 작성 후 하단의 기능을 작동하는 API를 만들어주시면 됩니다.

작동하는 API를 볼 수 있는 프론트 페이지를 만들어서 호출하면 됩니다.

DB구조에 정확한 정답은 없으며, 해당 구조로 만든 이유를 설명할 수 있으면 됩니다.

마지막으로 꼭 테스트 코드 작성을 부탁드립니다.


# Guidelines
- Doctalk 앱을 확인해 보시면 더 정확한 DB 구조를 작성하는게 가능합니다.
- Front js는 아무거나 사용하셔도 무방합니다.(vue.js 추천)
- Front 웹 페이지 디자인은 상관이 없으며, 해당 기능이 정상적으로 수행됨이 중요합니다.
- 테스트 코드를 필수로 작성 부탁드립니다.
- readme에 해당 설정 방법을 적어주세요
- 작업을 commit 단위로 나눠주세요(필수)

# APIs & Front

- Login API Example(email login)

    <img src="doctalk_login.PNG" width="300" height="500">

    이메일, 비밀번호가 일치 할 경우 success를 반환 해주세요

- Main List API1 Response Example

    <img src="doctalk_main_list.PNG" width="300" height="400">

    위 이미지의 데이터 리스트를 반환 해주세요

- Consult Detail Response Example
    - Question

        <img src="doctalk_question.PNG" width="300" height="290">

    - Answer

        <img src="doctalk_answer.PNG" width="300" height="500">

    위 이미지의 데이터를 반환 해주세요
