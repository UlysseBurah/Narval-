

const series = document.querySelector(".series");
const movies = document.querySelector(".movies");
const tl = new TimelineMax();  
const tl2 = gsap.timeline({ defaults: {ease: "power1.out"}})
const image = document.querySelector('#image_Flamme');
const fixed = document.querySelector('.fixed');
const header = document.querySelector('header');
const popup = document.querySelector('.popup');
const popup2 = document.querySelector('.domtree');
const footer = document.querySelector('footer');
const image2 = "https://images.alphacoders.com/691/thumb-1920-691791.jpg";



tl2.to(".text", {y:"0%", duration:1.5, stagger: 0.4});
tl2.to(".slider", {y:"-100%", duration:1.5, delay : 0.5});
tl2.to(".intro", {y:"-100%", duration:1}, "-=1" );
tl2.fromTo(".fixed", {opacity:"0"}, {opacity:1, duration:1});


// var tl3 = new TimelineMax({delay: 3, repeat: Infinity, repeatDelay: 3});
// tl3.from(image, 0.5, {autoAlpha: 0.5, x: +100})
// tl3.set(image,{attr:{src:image2}});
   
/// FIXED SCROLL EFFECT ///

$(window).on("scroll", function() {
    if($(window).scrollTop() > 250) {
        $(".fixed").addClass("active");
    } else {
        //remove the background property so it comes transparent again 
       $(".fixed").removeClass("active");
    }
});

// $(window).scroll(function() {

//     if ($(window).scrollTop()<=50) {
//         console.log('salut');
//         var test = 1;
        
//         $(".fixed").css({

//             "top": ($(window).scrollTop()) + "3px",
            
      
//         });
//     }
    
//     console.log($(window).scrollTop());
//   });

//// POPUP ////

$(document).ready(function(){
    setTimeout(function(){
       $(".popup").show();
     }, 8000);
 });

 var span = document.getElementsByClassName("close")[0];
 var span2 = document.getElementsByClassName("close2")[0];
 
 span.onclick = function() {
    popup.style.display = "none";
  }
  span2.onclick = function() {
    popup2.style.display = "none";
  }


  //// DOM TREE ////

  var $div = null;

  

$(function() {
    $('#tree').click(function() {
        if($div != null) {
            $div.remove();
            $div = null;
        }
        $div = $('<div></div>');
        displayTree($('html'), 0);
        $div.appendTo(".treecontent");
    });
});

function displayTree($parent, i) {
    //console.log($parent.prop("tagName").toLowerCase());
    var str = "";
    for(var j = 0; j < i; j++) {
        str += "&nbsp;&nbsp;&nbsp;&nbsp;";
    }
    str += $parent.prop("tagName").toLowerCase() + "<br>";
    $div.append(str);
    $parent.children().each(function() {
        displayTree($(this), i + 1);
    });
    popup2.style.display = "block";
}
  