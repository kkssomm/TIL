# PYTHON, DJANGO



## # Python 기초

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

- if

  ```
  ss
  ```

- for

  ```
  ss
  ```



### VSCODE 플러그인 설치

**(`ctrl` + `shift` + `p`) **

- beautify : 자동으로 인덴테이션 
- live server : 로컬호스트로 즉시 리로드
- bootstrap 





## # Flask

### 설치 및 기본 구현

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

  **Secure tunnels to localhost** : 로컬 서버에서 webhook을 호출하는 데 사용할 수있는 웹 터널링 도구 

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

 **ngrok을 사용하는 동안 별도의 터미널에서 manage.py가 실행 중이어야합니다 (python manage.py runserver 사용) 그렇지 않으면 webhook이 오류를 발생시킵니다.** 





## # Django

(Doc).[ https://docs.djangoproject.com/ko/2.2/ ]



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

  - 시간/ 언어 설정

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



### GET/POST

- 용도 
  - GET : 검색 폼
  - POST : 서버 시스템의 상태를 바꾸는 요청 (ex. 데이터베이스의 내용)

- Restful 방식

  ```python
  def create(request):
      if request.method == 'POST':
          title = request.POST.get('title')
          content = request.POST.get('content')
          image = request.FILES.get('image')
          article = Article(title=title, content=content, image=image)
          article.save()
          return redirect('articles:detail',article.pk)
      else : 
          return render(request, 'articles/new.html')
  ```

  - GET : 작성 페이지를 랜더링 함
  - POST : 요청 내용으로 데이터베이스 변경

- crsf_token

  ```
  {% crsf_token %}
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

- Model 코딩

  - `models.py`

    ```python
    class Article(models.Model):
        title = models.CharField(max_length=10)
        content = models.TextField()
        create_at = models.DateTimeField(auto_now_add=True)
        updated_at = models.DateTimeField(auto_now=True)
        
    ```

   def __str__(self):
            return f'{self.id}번 글 - {self.title} : {self.content}'
    ```
    
  
  - `admin.py`
  
    ```python
    from {앱 이름}.models import {테이블 이름}
    admin.site.register({테이블 이름})
    ```

  - 데이터 베이스 반영

    ```bash
    $ python manage.py createsuperuser # 관리자 생성
    $ python manage.py makemigrations # 변경 필요 사항 추출
    $ python manage.py migrate # 변경 사항 반영
    $ python manage.py runserver # 웹서버 기동
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



**파이썬 쉘**

```bash
$ python manage.py shell

# 생성
>>> from articles.models import Article
>>> article = Article()
>>> article.title = 'first'
>>> article.content = 'django'
>>> article= Article(title='second',content='edition')
>>> article.save()
>>> Article.objects.create(title=title,content=content)

#조회
>>> article
<Article: Article object (2)>
>>> Article.objects.all()
<Article: Article object (2)>

# __str__
>>> Article.objects.all()
<QuerySet [<Article: 1번 글 - first : django>, <Article: 2번 글 - second : edition>, 

# filter로 조회
>>> Article.objects.filter(title='first')
<QuerySet [<Article: 1번 글 - first : django>, <Article: 5번 글 - first : hahaha>]>

# get으로 조회
>>> Article.objects.get(pk=1)
<Article: 1번 글 - first : django>

>>> article=Article.ojbects.get(pk=4)
Traceback (most recent call last):
  File "<console>", line 1, in <module>
AttributeError: type object 'Article' has no attribute 'ojbects' #오류

# 수정
>>> article=Article.objects.get(pk=4)
>>> article.title='4th'
>>> article.save()
>>> Article.objects.all()
<QuerySet [<Article: 1번 글 - first : django>, <Article: 2번 글 - second : edition>, <Article: 3번 글 - third : eye>, <Article: 4번
글 - 4th : kind>, <Article: 5번 글 - first : hahaha>]>
```

***extensions 적용** : import문 생략 가능

```
(bash)
$ pip install django-extensions

(setting.py) 
INSTALLED_APPS = [
    'django_extensions',
]

(bash)
$ python manage.py shell_plus
```



### File

```bash
$ pip install Pillow

$ pip install django-imagekit

$ pip install pilkit
```





### Form 

**장고의 폼 처리 기능**

​	a. 폼 생성에 필요한 데이터를 폼 클래스로 구조화

​	b. 폼 클래스의 데이터를 랜더링하여 HTML 폼 만들기

​	c. 사용자로부터 제출된 폼과 데이터를 수신하고 처리



- 폼 클래스 정의

  : 폼을 클래스로 정의해 간편하게 폼을 생성함

  - `form.py`

  ```python
  from django import forms
  from .models import Article
  
  class ArticleForm(forms.ModelForm):
      title = forms.CharField(
          max_length=10,
          label = '제목',
          widget = forms.TextInput(
              attrs = {
                  'class': 'my-title',
                  'placeholder': 'Enter the title',
              }
          )
          )
      content = forms.CharField(
          label = '내용',
          widget=forms.Textarea(
               attrs={
                   'class': 'my-content',
                   'placeholder': 'Enter the content',
                   'rows': 5,
                   'cols': 50,
               }
          )
          )
      
  class Meta:
          model = Article
          fields = ['title', 'content',]
  ```

  

- 뷰에서 폼 클래스 처리

  : 폼을 보여주거나 처리함

  - `view.py` -> GET : 빈 폼 생성 / POST : 폼 객체를 생성해 요청된 데이터로 채움

    ```python
    def create(request):
        if request.method == 'POST':
            form = ArticleForm(request.POST)
            if form.is_valid(): 
                article = form.save()
                return redirect('articles:index')
        else:
            form = ArticleForm()
            return render(request, 'articles/form.html', {'form':form})
    ```

    -  `form=폼객체(request.POST)` : 요청에포함된 데이터로 채움
    - `form.is_valid()` form이 유효한지 검사
    - `form.cleaned_data.get('속성')` :  데이터를 요청받은대로 처리



- 폼 클래스를 템플릿으로 변환

  - `form.html`

    ```html
    <form action="" method="POST">
    	{% csrf_token %}
        {{ form.as_p }}
        <input type = "submit" value="Submit">
    </form>
    ```

    - `form.as_p`: 폼을 <p> 태그로 감싸도록 랜더링 됨



**Form에 Bootstrap 적용**

- 설치 및 환경설정

  - pip install

  ```bash
  $ pip install django-bootstrap4
  ```

  - `settings.py`

  ```python
  INSTALLED_APPS = [
    'bootstrap4',
  ]
  ```

- 뷰에서 폼 클래스 처리

  - `views.py`

    ```python
    def update(request, article_pk):
        article = get_object_or_404(Article, pk=article_pk)
        if request.method =='POST':
            form = ArticleForm(request.POST, instance=article)
            if form.is_valid():
                article = form.save()
                return redirect('articles:detail', article.pk)
        else:
            form = ArticleForm(instance=article)
        return render(request,'articles/form.html',{'form':form, 'article':article})
    ```

    - `form.save()`
    - `form=폼객체(request.POST, instance=튜플)`
    - ``form = 폼객체(instance=튜플)`

  - `form.html`

    ```html
    {% load bootstrap4 %}
    
    {% if request.resolver_match.url_name == 'create' %}
    <h1 class='text-center'>CREATE</h1>
    {% else %}
    <h1 class='text-center'>EDIT</h1>
    {% endif %}
    <hr>
    
    <form action="" method="POST">
        {% csrf_token %}
        {% bootstrap_form form layout='horizontal' %}
        {% bootstrap_button "등록" button_type='submit' button_class='btn btn-dark' %}
    </form>
    
    {% if request.resolver_match.url_name == 'create' %}
    <a href="{% url 'articles:index' %}">[BACK]</a>
    {% else %}
    <a href="{% url 'articles:detail' article.pk %}">[BACK]</a>
    {% endif %}
    ```

    - `{load bootstrap4}`
    - `request.resolver_match.url_name`

    - `bootstrap_form form layout='horizontal'`



**외래키 처리**

- `views.py`

  ```python
  def detail(request, article_id):
      article = Article.objects.get(pk=article_id)
      comments = article.comment_set.all()
      comment_form = CommentForm()
      return render(request, 'articles/detail.html',{'article':article,'comments':comments,'comment_form':comment_form})
  
  def comment_create(request,article_id):
      article = Article.objects.get(pk=article_id)
      comment_form = CommentForm(request.POST)
      	if request.method == 'POST':
      		comment = comment_form.save(commit=False)
      		comment.article = article
      		coment.save()
      		return redirect('articles:detail',article.id)
      else:
           return redirect('articles:detail',article_id)
  ```

  - `    comment = comment_form.save(commit=False)`    
  - `comments = article.comment_set.all()`

  

**@require_POST**

- `views.py`

  ```python
  from django.views.decorators.http import require_POST
  
  @require_POST
  def comment_create(request,article_id):
      article = Article.objects.get(pk=article_id)
      comment_form = CommentForm(request.POST)
      comment = comment_form.save(commit=False)
      comment.article = article
      comment.save()
      return redirect('articles:detail',article_id)
  
  ```



## 로그인



```python
from django.contrib.auth.forms import UserCreationForm
```

```
user1.article_set.all()

for article in user1.article_set.all()
	for comment in article.comment_set.all():
		print()?
		
c2.user

c2.user.name

c2.user.article_set.all() // c2의 user가 쓴 모든 글

article1.comment_set.all() 

article1.comment_set.first().user.name // 1번째 글의 첫번째 댓글을 쓴 사람의 이름

article1.comment_set.all()[0].user.name

article1.comment_set.all()[1:4]

article1.comment_set.all()[1].user.article_set.all()[0].comment_set.all()
# 첫번째 글의 두번째 댓글을 쓴 사람의 첫번째 글의 댓글 목록

```



### M-N relationship

kakaodeveloper 

일반 플랫폼추가 웹  http://127.0.0.1:8000 https://127.0.0.8000

사용자 관리 on 프로필정보 수집 목적 작성 / 로그인 Redirect URL http://127.0.0.1:8000/accounts/kakao/login/callback/ 추가



admin

   소셜어플리케이션 클라이언트아이디:REST API 키 

키: 고급 상태on 코드

stites : example.com