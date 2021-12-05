export class AnimalComponent {
    constructor(parent) {
        this.parent = parent
    }

    getHTML(data) {
        return (
            `
                <div class="card mb-3"><!--style="width: 540px;"-->
                    <div class="row g-0">
                        <div class="col-md-4">
                            <img src="${data.animal_photo}" class="img-fluid" alt="фото">
                        </div>
                        <div class="col-md-8">
                            <div class="card-body">
                                <h5 class="card-title">${data.animal_name}</h5>
                                <p class="card-text">${data.animal_type}</p>
                            </div>
                        </div>
                    </div>
                </div>
            `
        )
    }

    render(data) {
        const html = this.getHTML(data)
        this.parent.insertAdjacentHTML('beforeend', html)
    }
}