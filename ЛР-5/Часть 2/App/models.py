from django.db import models


# Create your models here.
class Animal(models.Model):
    animal_type = models.CharField('Вид животного', max_length=50)
    animal_name = models.CharField('Кличка животного', max_length=50)
    animal_photo = models.URLField('Фото жифотного', max_length=200)

    def __str__(self):
        return f'Тип: {self.animal_type}; Имя: {self.animal_name}; URL фото: {self.animal_photo}'

    class Meta:
        verbose_name = 'Животное'
        verbose_name_plural = 'Животные'


class Animal_review(models.Model):
    animal = models.ForeignKey(Animal, on_delete=models.CASCADE)
    author = models.CharField('Имя автора', max_length=50)
    review_text = models.CharField('Текст отзыва', max_length=200)

    def __str__(self):
        return f'Автор: {self.author}, Отзыв: {self.review_text}'

    class Meta:
        verbose_name = 'Отзыв'
        verbose_name_plural = 'Отзывы'
