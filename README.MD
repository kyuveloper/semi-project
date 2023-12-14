### main에서 작업시 충돌 해결 방법
내가 메인에서 만들어서 충돌 남 <br>
같은 main이라 안됐던거임 <br>
이 경우에 강제로 합쳐주는 git stash를 사용한다
### 개인 branch 생성 - 이동 - 커밋
1. git branch (branch 이름) : 입력한 이름의 branch 생성
2. git branch : 내가 어느 branch에 있는지 어떤 branch가 있는지 확인 용도
3. git checkout (branch 이름) : 입력한 이름의 branch로 이동 <br>주의 사항: 작업하고 있던 것을 commit 하지 않으면 이동이 불가능함
4. 작업물을 어느정도 만든후
5. git add .
6. git commit -m "이름"
7. git push origin (branch 이름)
### main branch와 다른 branch의 병합 방법
1. git checkout main : main에 병합할 것이니 main으로 이동
2. git merge (branch 이름) : 입력한 이름의 branch를 main에 병합<br> git merge 는 병합 main에서 git push해야됨
3. git branch --merged : 병합이 됐는지 확인
### commit 되돌리기 다시 불러오기
git log : log를 확인한다. 종료 Q <br> ![로그확인.png](/image/로그확인.png)