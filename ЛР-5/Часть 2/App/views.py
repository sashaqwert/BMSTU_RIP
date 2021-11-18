from django.http import Http404, HttpResponseRedirect
from django.shortcuts import render
from django.urls import reverse
from .models import Animal


def index(request):
    a_list = Animal.objects.all()
    return render(request, 'App/list.html', dict([('a_list', a_list)]))


def detail(request, animal_id):
    try:
        a = Animal.objects.get(id=animal_id)
    except:
        raise Http404('Животное не найдено!')
    reviews = a.animal_review_set.order_by('-id')
    return render(request, 'App/detail.html', dict([('animal', a), ('review_list', reviews)]))



def leave_review(request, animal_id):
    try:
        a = Animal.objects.get(id=animal_id)
    except:
        raise Http404('Животное не найдено!')
    a.animal_review_set.create(author=request.POST['name'], review_text=request.POST['text'])
    return HttpResponseRedirect(reverse('App:detail', args=(a.id,)))
