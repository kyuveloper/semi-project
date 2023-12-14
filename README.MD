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
### main에서의 데이터 받는 방법
git pull 또는 git pull origin main
### commit 확인, 취소, 다시 불러오기
#### log 확인방법
git log : log를 확인한다. 종료 Q <br> ![로그확인.png](image/로그확인.png)<br>
commit 오른쪽의 데이터가 로그임 하지만 이름이 너무 긴 문제가 있다<br>
3번커밋의 log이름은 bf0c317bb8e9bc482e92a5c3e81ff5fc380b1106
![로그확인2.png](image/로그확인2.png)
git을 누르고 오른쪽 하단을 보면 log의 이름이 간소화되서 나온다 <br>
간소화된 3번커밋의 이름은 bf0c317b <br>
#### commit 취소 및 불러오기 방법
git revert 로그이름 : 로그이름을 취소한다 <br>
git reset --hard 로그이름 : 취소한 로그이름을 다시 불러온다<br>
#### 예시
sh.MD에 있는 현재 상황<br>
![현재상태.png](image/현재상태.png)<br>
git revert bf0c317b 입력<br>
![revert입력.png](image/revert입력.png)<br>
git revert bf0c317b 입력 후 결과<br>
![rever한결과.png](image/revert한결과.png)<br>
git rest --hard bf0c317b 입력<br>
![rest입력.png](image/rest입력.png)<br>
git rest --hard bf0c317b 입력 후 결과<br>
![rest한결과.png](image/rest한결과.png)<br>
git revert bf0c317b을 입력하면 git commit 되돌리기3이 취소된걸 확인 할 수 있다<br>
git rest --hard bf0c317b를 입력하면 취소됐던 git commit 되돌리기3 을 다시 불러왔다
#### 주의사항
commit 한 순서대로 취소를 해야됨 안그러면 충돌남
