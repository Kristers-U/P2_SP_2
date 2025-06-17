function initializeTheme() {
    let theme = localStorage.getItem("theme");
    //default pref
    if (!theme && window.matchMedia("(prefers-color-scheme: dark)").matches) {
        theme = "dark";
    } else {
        theme = theme || "light";
    }
	//toggle
    document.body.classList.toggle("dark-mode", theme === "dark");
    return theme;
}

document.addEventListener("DOMContentLoaded", function() {
    const currentTheme = initializeTheme();
    const themeButtons = document.querySelectorAll(".dark-mode-toggle");
    
    //button text
    themeButtons.forEach(button => {
        button.textContent = currentTheme === "dark" ? 
            "Pārslēgt uz gaišo režīmu" : 
            "Pārslēgt uz tumšo režīmu";
    });

    themeButtons.forEach(button => {
        button.addEventListener("click", function(event) {
            const newTheme = currentTheme === "dark" ? "light" : "dark";
            
            //update theme
            localStorage.setItem("theme", newTheme);
        });
    });
});
