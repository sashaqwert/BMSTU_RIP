from django.urls import path
from . import views


app_name = 'App'
urlpatterns = [
    path('', views.index, name='index'),
    path('<int:animal_id>', views.detail, name='detail'),
    path('<int:animal_id>/leave_review', views.leave_review, name='leave_review')
]
