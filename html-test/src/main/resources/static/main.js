const slide_img = document.querySelectorAll('.slide_img')
var counter = 0;

slide_img.forEach(
    (slide, index) => {
        slide.style.left = `${index * 100}%`
    }
)
const goPrev = () => {
    counter--
    if(counter == -1) {
        counter = 2
    }
    slideImage()
}
const goNext = () => {
    counter++
    if(counter == 3) {
        counter = 0
    }
    slideImage()
}

const slideImage = () => {
    slide_img.forEach(
        (slide) => {
            slide.style.transform = `translateX(-${counter * 100}%)`
        }
    )
}


let target = document.querySelector('#dynamic');

function randomString() {
    let stringList = [
        "반려동물과 함께하는 나만의 개인 비서",
        "내 강아지를 위한 똑똑한 반려동물 지도",
        "우리 강아지를 위한, 똑똑한 반려동물 지도",
        "반려동물과 함께하는 호캉스를 위한",
        "우리 강아지와 함께 갈 수 있는 장소는 예상보다 많습니다"];
    let selectString = stringList[Math.floor(Math.random() * stringList.length)];
    let selectedStringAl = selectString.split("");
    return selectedStringAl;
}
function resetTyping() {
    target.textContent = "";
    dynamic(randomString());
}
function dynamic(randomList) {
    if (randomList.length > 0) {
        target.textContent += randomList.shift();
        setTimeout(function() {
            dynamic(randomList);
        }, 80);
    } else {
        setTimeout(resetTyping, 2000);
    }
}
dynamic(randomString());
function twinkle() {
    target.classList.toggle("twinkle");
}
setInterval(twinkle, 500);


const myPageBtn = document.querySelector('.main_mypage');
const myPageBox = document.querySelector('.myPage_menus');

myPageBtn.addEventListener('click', () => {
    myPageBox.classList.toggle('show');
})