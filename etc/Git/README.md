# Git



## 기본 명령어 

1. 저장소 초기화

```
git add

git commit
```



## Git 되돌리기

1. commit 메세지 수정

   ``` 
   $ git commit --amend
   ```

   - git bash 에서 vim이 실행된다.
   - 편집모드(i) 상태에서 수정후 esc +':wq'
   - push, 즉 원격 저장소에 올린 이후에는 진행하면 충돌이 발생한다.
   - 커밋을 다시 하게되면 해시값이 변경되기 때문



2. staging area(INDEX)에서 취소하기

   ```
   $ git reset HEAD programmers/
   $ git status
   On branch master
   Changes to be committed:
     (use "git restore --staged <file>..." to unstage)
           modified:   "백준알고리즘/1001.py"
   
   Untracked files:
     (use "git add <file>..." to include in what will be committed)
           programmers/
   ```



3. git 이력에서 특정 파일 삭제 커밋

   ```
   $ git rm --cached 파일명
   ```

   - 한번도 커밋된 이력이 없을 때에는 staging area에서 취소와 동일함.

   - 다만, 커밋에 포함된 적 있는 경우에는 삭제 커밋이 됨 (실제 파일은 삭제되지 않음)

     

4. 특정 파일 포함해서 다시 커밋

   ```
   $ git add a.py
   $ git commit -m 'a, b 추가'
   $ git add b.py
   $ git commit --amend
   ```

   - commit 메시지를 수정하기 전에 staging area에 변경을 해주면, 해당 파일까지 포함하여 다시 커밋을 진행함.

     

5. 현재 작업 내역 커밋 시점으로 되돌리기

   예를 들어, 특정 파일을 삭제하였거나 혹은 코드 수정과정에서 오류가 많이 발생하여 직전 커밋 시점상태로 돌아가고 싶을 대 사용이 가능함.

   ```3. git checkout --파일명
   $ git checkout --파일명 
   ```







## 원격 저장소 (github) 활용하기



1. 원격 저장소 설정

   ```$ git remote add origin {url}
   $ git remote add origin {url}
   ```

   

2. 원격 저장소 확인

   ``` 
   $ git remote -v
   origin  https://github.com/kkssomm/test.git (fetch)
   origin  https://github.com/kkssomm/test.git (push)
   ```

   

3. 원격 저장소에 push

   ``` 
   $ git push origin master
   ```

   

4. 원격 저장소 삭제

   ``` 
   $ git remote rm origin
   ```

    

5.  원격 저장소 복제

   ``` 
   $ git clone {url}
   ```

   - 로컬에 원격 저장소를 받아오고 싶다면 colne으로 가져온다.
   - 이후에는 push -pull을 통해서 업데이트 한다.



## 충돌 해결하기 (Megre conflict)

> 기본적으로 push-pull 하는 과정에서 동일한 파일의 다른 이력이 기록될 경우 충돌이 발생한다.
>
> 다른 파일이 수정되는 경우 fast-forwarding을 통해 자동으로 merge 되기도 함 
>
> 오류를 발생시키지않으려면 작업 전 습관적으로 pull 하도록 하자



1. LOCAL A 에서 a.txt 작성후 커밋

2. LOCAL A 에서 원격저장소(Origin)로 push

3. LOCAL B에서 pull 하지 않은 상태에서 a.txt 동일한 라인 작성 후 커밋

4. LOCAL B에서 원격 저장소(Origin)로 push->push 되지않음

   

5. 해결 ( 원격 저장소  변경사항 local  b에 반영)

   ``` 
   $ git pull origin master
   ```

   

6. 충돌발생(동일 파일 수정시)

- 어떤 파일에서 충돌되었는지 확인하는 명령어

```
$ git log --oneline --left-right --p
```

- git에서 직접 충돌 파일에 기록을 남겨줌

  <<<<<<HEAD

  집 수정 내용

  ========

  멀캠수정내용

  

  - head 현재 작업하고 있는 곳(Local B)

  - 해쉬값 : pull을 통해서 받아온 변경사항(origin)

  - 해당하는 위치를 찾아서 직접 수정을 진행함

    

7. merge conflict 해결 commit 남기기

```
$ git stataus
git add .
$git commit -m "Merge conflick" 해결
```



8. 원격 저장소로 push

   ``` 
   git push origin master
   ```





## Branch 활용하기

`git init` 을 하였을 때 `(master)` 는 사실 master 브랜치에 있다라는 사실을 보여주고 있는 것이다.

1. branch 생성

   ```
   (master) $ git branch {branch이름}
   (master) $ git branch
   *master
   {branch이름}
   ```

2. branch 이동

   ```
   $ git checkout {branch이름}
   ```

   - 위 두 명령어를 동시에 실행하려면 아래와 같이 한다.

     ```
     $ git checkout -b {branch이름}
     ```

3. branch 삭제

   ```
   $ git branch -d {브랜치이름}
   ```

4. branch 병합

   ```
    (master) $ git merge {branch 이름}
    (master) $ git branch
    (master) $ 
   ```

   'master' 브랜치에 'feature/main'을 병합한다.

   항상 병합을 하고 싶은 대상의 브랜치로 옮겨서 진행해야 한다.



## Git merge

### 1.Fast-forwarding

실제로 브랜치를 나눈 이후에 master 브랜치에 커밋이 발생하지 않았고, 단순히 커밋만 옮기면 되는 겨우. merge 커밋이 발생하지는 않음

### Auto Merge

브랜치를 나눈 이후에 master 브랜치에 커밋이 발생하였으나, 동일한 파일이 수정되지 않아서 자동으로 병합이 되는 경우. merge 커밋이 발생함

```
$ git log --graph --oneline
*   85cd33b (test) Merge branch 'feature/main'
|\
| * 42df5bb Complete main feature
* | 90cf6e6 README
|/
* 98aa976 Init css/js
```



### 3. Merge conflict 발생

브랜치를 나눈 이후에 master 브랜치에 커밋이 발생하였고, 동일한 파일이 각자 다른 브랜치에서 수정된 경우 자동으로 merge가 되지 않는다. 따라서 merge conflict가 발생하고, 직접 수정 후 커밋을 해야한다.

```
$ git merge feature/main
Auto-merging README.md
CONFLICT (content): Merge conflict in README.md
Automatic merge failed; fix conflicts and then commit the result.
```

Git은 충돌이 발생한 파일에 아래와 같이 표기를 해준다. 해당 부분을 찾아서 수동으로 해결 해야한다. 충돌 위치를 파악하기 위해서 `git status` 를 통해 확인하자!

```
<<<<<<< HEAD
Master 수정
=======
Branch 수정
>>>>>>> feature/footer
$ git add .
$ git commit
```

커밋을 하게 되면, merge 커밋이 발생한다.

```
$ git log --graph --oneline
*   4ef20fb (HEAD -> master) Merge branch 'feature/footer'
|\
| * 9701912 (feature/footer) Complete footer
* | c932f24 README
|/
*   85cd33b (test) Merge branch 'feature/main'
```



## Git stash

현재 변경 사항을 담아 둘 수 있는 임시 공간이 존재한다.

1. 현재 변경사항 담기

   ```
   $ git stash
   $ git stash list
   ```

2. 임시 저장사항 불러오기

```
$ git stash pop
```

위의 명령어는 apply + `drop`과 동일하다.







## 참조페이지

구글 docs [bit.do/openapi-a](http://bit.do/openapi-a)



TIL 예시 <https://github.com/edutak/algorithms>

git md 정리 내용 <https://gist.github.com/edutak/0b3ec40bdecbc9bad074e8df1e5a7998>

git 입문편 https://backlog.com/git-tutorial/kr/intro/intro1_1.html



잘 정리된 예시

기술 면접 가이드 <https://github.com/JaeYeopHan/Interview_Question_for_Beginner>

논산 <https://github.com/krta2/awesome-nonsan>

자율 출퇴근 <https://github.com/milooy/remote-or-flexible-work-company-in-korea>



커밋 메시지

본문/명령문 <https://meetup.toast.com/posts/106>

커밋 낱말 사전 <https://blog.ull.im/engineering/2019/03/10/logs-on-git.html>



git 시각화 <http://git-school.github.io/visualizing-git/>



Github Pages

[https://startbootstrap.com](https://startbootstrap.com/)

<https://fontawesome.com/>

