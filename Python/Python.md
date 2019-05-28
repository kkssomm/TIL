## Python 기초

### 가상 환경 구축 & Jupyter Notebook 설치

``` bash
$ python -m venv venv # 가상환경 구축
$ source ./venv/Scripts/activate

$ code .  # visual code 실행
 
$ pip list
$ python -m pip install --upgrade pip

$ pip install jupyter notebook # jupyter notebook
$ jupyter notebook
```

c 

### 자료구조

- 배열

- 리스트

- 딕셔너리

  

### 반복문

- if & elif & else

``` python
ss
```

- for



### VSCODE 플러그인 설치

- beautify : 자동으로 인덴테이션 (ctrl + shift + p)

- live server - 로컬호스트로 즉시 리로드

- bootstrap



## Flask

- Flask 설치

```python
$ pip install flask
$ FLASK_APP={파일명} flask run
$ flask run # 파일명 : app.py
```

- `app.py` 생성

```python
from flask import Flask
app = Flask(__name__)

@app.route('/')
def index():
    return 'Hello Flask'
```

- 서버구동

  ``` python
  $ FLASK_APP=flask_ex.py flask run 
  ($ flask run)
  ```

  - http://127.0.0.1:5000/ 

- 템플릿 추가

  - templates 폴더에 {파일명}.html 생성
  - `app.py`에서 랜더링

  ```python
  return render_template('{파일명}.html')
  ```





### 텔레그램 연동

- TOKEN

  - decouple 설치

    ```	bash
    $ pip install decouple	
    ```

  - 텔레그램 py 파일

    ```python
    import decouple import config
    
    base = "https://api.telegram.org"
    token = config('TOKEN')
    ```

  - `.env`

    ```
    TOKEN = '{토큰}'
    ```

  - 이전 bot 웹훅에서 지우기

    `https://api.telegram.org/bot{토큰값}/deleteWebhook`

- ngrok  

  **Secure tunnels to localhost** :방화벽 넘어서 외부에서 로컬에 접속 가능하게 하는 터널 프로그램 

  - ngrok (설치).[ https://dashboard.ngrok.com/get-started ]

  - 텔레그램 py 파일 경로에 `ngrok.exe`

  - 계정에 연결
  
    ```bash
    $ ./ngrok authtoken {ngrok TOKEN}
    ```
    
  - 외부에서 서버 접속
  
    `Forwarding`으로 접속하면  로컬의 `127.0.0.1.5000`으로 접속을 연결해준다.
  
    ``` bash
    $ ./ngrok http 5000
    ```





## Django

(참조 페이지).[ https://docs.djangoproject.com/ko/2.2/ ]



### 프로젝트 만들기

- Django 설치

  ```bash
  $ pip install django
  ```

- 프로젝트 생성

  ```bash
  $ django-admin startproject {프로젝트 이름}
  ```

- 앱 생성

  ```bash
  $ cd {프로젝트 이름}
  $ django-admin startapp {앱 이름}
  ```

- `settings.py` 

  - `ROOT_URLCONF` : 최상위 URL conf(urls.py)의 위치를 알아냄
  - `INSTALLED_APPS`

  ```python
  INSTALLED_APPS = [
      '{추가한 앱 이름}',
      ...
  ]
  ```

  - etc

    ```
    LANGUAGE_CODE = 'ko-kr'
    TIME_ZONE = 'Asia/Seoul'
    ```

- `{프로젝트}/urls.py`

  - URLconf를 로딩하여 urlpatterns 변수에 지정되어 있는 URL리스트를 검사
  - 매치된 URL의 뷰(클래스의 메소드)를 호출

  ```python
  from django.urls import include, path
  
  urlpatterns =[
      path('{url}', include('{앱}.urls') ),
      path('admin/', admin.site.urls),
  ]
  ```

  - `path()` : route(URL패턴), view(호출되는 함수), kwargs(추가적 인자), name(패턴별 이름) 인자를 가짐
  - `include()` : 같은 url 패턴을 포함한 경로에 연결해 줌

- 작동

  ```bash
  $ python manage.py runserver
  ```



### 데이터베이스

- 데이터 베이스 엔진 설정

  - `settings.py`

  ```python
  DATABASES = {
      'default': {
          'ENGINE': 'django.db.backends.sqlite3',
          'NAME': os.path.join(BASE_DIR, 'db.sqlite3'),
      }
  }
  ```

- 테이블 생성

  ```bash
  $ python manage.py migrate
  ```

- 관리자 생성

  ```bash
  $ python manage.py createsuperuser
  ```

- Model 코딩

  ```bash
  notepad models.py # 테이블 정의\
  python manage.py makemigrations # 변경 필요 사항 추출
  python manage.py migrate # 변경 사항 반영
  python manage.py runserver # 웹서버 기동
  ```

- admin 사이트에 테이블 반영

  `admin.py`

  ```bash
  from {앱 이름}.models import {테이블 이름}
  
  admin.site.register({테이블 이름})
  ```

- 함수 작성

  `views.py`

  - 데이터베이스 클래스 임포트

    ```python
    form {앱 이름}.models import {테이블 이름}
    ```

  - 객체 생성

    ```python
    def index(request):
        latest_question_list = Question.objects.all().order_by('-pub_date')[:5]
        # pub_date 속성을 역순으로 정렬하여 최근 5개의 Question객체를 가져옴
        context = {'latest_question_list':latest_question_list}
        return render(request, 'polls/index.html',context)
    ```

    