### branch 관련 명령어들
git branch (이름) : branch 만들기 <br>
git branch : 내가 어떤 branch에 있는지 확인 <br>
git checkout (이름), git switch (이름) : 이름의 branch로 이동 <br>
git add . : 모든 변경사항을 다음 commit에 반영 <br>
git commit -m "커밋 명" : 메세지와 함께 commit 하기 <br>
git push origin (이름) : 원격 저장소에 push 하기 <br>
git pull : 다른 이용자가 미리 올려놓은 데이터 받기
### 병합하는 방법 <br>
1. git checkout (장소) : 지정해준 장소(보통 main같음)로 이동 한 후
2. git merge (이름) : 이름의 branch를 merge로 등록
3. git branch --merged : merged(병합)된 branch의 목록 <br>

### 과거 commit으로 돌아가는방법
1. revert : commit된 파일을 취소하고 기록을 남긴다
2. reset : 해당 commit의 위치로 이동하고 기록도 날린다<br>reset은 되돌릴 수 없는 삭제라 신중해야 하며
데이터 손실로도 이어질 수 있어서 가급적 안하는게 좋다

git commit 되돌리기용
git commit 되돌리기1
git commit 되돌리기2
git commit 되돌리기3

