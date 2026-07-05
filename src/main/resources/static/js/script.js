/*=========================================
        NOVAFLOW SCRIPT V2
=========================================*/

// Navbar Shadow on Scroll

window.addEventListener("scroll", function () {

    const navbar = document.querySelector(".navbar");

    if (window.scrollY > 50) {

        navbar.style.background = "rgba(7,19,32,.92)";
        navbar.style.boxShadow = "0 10px 30px rgba(0,0,0,.30)";

    } else {

        navbar.style.background = "rgba(7,19,32,.55)";
        navbar.style.boxShadow = "none";

    }

});

// Smooth Fade Animation

const observer = new IntersectionObserver((entries) => {

    entries.forEach(entry => {

        if (entry.isIntersecting) {

            entry.target.classList.add("fade-up");

        }

    });

});

document.querySelectorAll(".feature-box,.product-card,.testimonial-card")
    .forEach((el) => observer.observe(el));
/*=========================================
        CURSOR GLOW
=========================================*/

const glow = document.createElement("div");

glow.className = "cursor-glow";

document.body.appendChild(glow);

document.addEventListener("mousemove",(e)=>{

    glow.style.left=e.clientX+"px";

    glow.style.top=e.clientY+"px";

});
/*=========================================
        PREMIUM LOADER
=========================================*/
window.addEventListener("load",()=>{

    setTimeout(()=>{

        const loader=document.getElementById("loader");

        loader.style.opacity="0";
        loader.style.transform="scale(1.08)";

        setTimeout(()=>{

            loader.style.display="none";

        },700);

    },2500);

});