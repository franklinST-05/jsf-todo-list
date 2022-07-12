const btnOpnModal = document.getElementById("btnOpnModal");
const inTask = document.getElementById("inTask");

btnOpnModal.addEventListener("click",openModalTask);

function openModalTask() {
    const modal = document.querySelector("#modalAddTask");
    modal.classList.toggle("open");
    btnOpnModal.classList.toggle("opened");

}