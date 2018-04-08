import Vue from 'vue'
import Router from 'vue-router'
import MainPage from '@/components/MainPage'
import CatalogPage from '@/components/CatalogPage'
import ArticlePage from '@/components/ArticlePage'
import AdminPage from '@/components/AdminPage'
import LoginPage from '@/components/LoginPage'
import EditPage from '@/components/EditPage'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'MainPage',
      component: MainPage
    },
    {
      path: '/login/',
      name: 'LoginPage',
      component: LoginPage
    },
    {
      path: '/article/',
      redirect: {name: 'MainPage'}
    },
    {
      path: '/article/:id',
      name: 'ArticlePage',
      component: ArticlePage
    },
    {
      path: '/edit/',
      name: 'EditPage',
      component: EditPage
    },
    {
      path: '/catalog/',
      name: 'CatalogPage',
      component: CatalogPage
    },
    {
      path: '/admin/',
      name: 'AdminPage',
      component: AdminPage
    }
  ]
})
