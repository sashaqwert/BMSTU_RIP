class Urls {
    constructor() {
        this.url = 'http://localhost:8000/';
    }

    animals() {
        return `${this.url}animals/`
    }

    animal(id) {
        return `${this.url}animals/${id}/`
    }
}

export const urls = new Urls()
