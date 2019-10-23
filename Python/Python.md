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



### Flask

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

    `https://api.telegram.org/bot{토큰값}/delete/Webhook`

- ngrok

  - ngrok (설치).[ https://dashboard.ngrok.com/get-started ]

  - 텔레그램 py 파일 경로에 `ngrok.exe`

  - 계정에 연결

    ```bash
    $ ./ngrok authtoken {ngrok TOKEN}
    ```