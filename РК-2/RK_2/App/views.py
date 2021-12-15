from rest_framework import viewsets
from .serializers import CourseSerializer, GroupSerializer
from .models import Course, Group
from django.shortcuts import render
from django.http import Http404


# Create your views here.
class CourseViewSet(viewsets.ModelViewSet):
    queryset = Course.objects.all()
    serializer_class = CourseSerializer


class GroupViewSet(viewsets.ModelViewSet):
    queryset = Group.objects.all()
    serializer_class = GroupSerializer


def CourseList(request):
    return render(request, 'course/list.html', {'c_list': Course.objects.all()})


def GroupList(request):
    return render(request, 'group/list.html', {'g_list': Group.objects.all()})


def CourseView(request, course_id=0):
    try:
        c = Course.objects.get(id=course_id)
    except:
        raise Http404('Курс не найден!')
    return render(request, 'course/detail.html', {'course': c})


def GroupView(request, group_id):
    try:
        g = Group.objects.get(id=group_id)
    except:
        raise Http404('Группа не найдена!')
    return render(request, 'group/detail.html', {'group': g})
