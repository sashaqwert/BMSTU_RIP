from django.http import Http404, HttpResponseRedirect
from django.shortcuts import render
from .models import Animal


def index(request):
    a_list = Animal.objects.all()
    return render(request, 'master/list.html', dict([('a_list', a_list)]))

def detail(request, animal_id):
    try:
        a = Animal.objects.get(id=animal_id)
    except:
        raise Http404('Животное не найдено!')
    return render(request,'master/detail.html', dict([('animal', a)]))