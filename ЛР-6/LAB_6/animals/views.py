from django.shortcuts import render
from rest_framework import viewsets
from .serializers import AnimalSerializer
from .models import Animal


# Create your views here.
class AnimalViewSet(viewsets.ModelViewSet):
    """
    API endpoint, который позволяет просматривать и редактировать акции компаний
    """
    # queryset всех пользователей для фильтрации по дате последнего изменения
    queryset = Animal.objects.all()
    serializer_class = AnimalSerializer  # Сериализатор для модели
