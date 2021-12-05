import {AnimalCardComponent} from "../../components/animal-card/AnimalCardComponents.js";
import {AnimalPage} from "../animal/AnimalPage.js";
import {ajax} from "../../modules/ajax.js";
import {urls} from "../../modules/urls.js";

export class MainPage {
    constructor(parent) {
        this.parent = parent;
    }

    async getData() {
        return ajax.get(urls.animals())
    }

    get page() {
        return document.getElementById('main-page')
    }

    getHTML() {
        return (
            `
            <div id="main-page" class="d-flex flex-wrap"><div/>
        `
        )
    }

    clickCard(e) {
        const cardId = e.target.dataset.id
        
        const animalPage = new AnimalPage(this.parent, cardId)
        animalPage.render()
    }

    async render() {
        this.parent.innerHTML = ''
        const html = this.getHTML()
        this.parent.insertAdjacentHTML('beforeend', html)

        const data = await this.getData()
        data.data.forEach((item) => {
            const AnimalCard = new AnimalCardComponent(this.page)
            AnimalCard.render(item, this.clickCard.bind(this))
        })
    }
}
