from rest_framework import serializers
from .models import Animal


class AnimalSerializer(serializers.ModelSerializer):
    class Meta:
        # Модель, которую мы сериализуем
        model = Animal
        # Поля, которые мы сериализуем
        fields = ["id", "animal_type", "animal_name", "animal_photo"]
