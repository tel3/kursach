import Vue from 'vue'
import Router from 'vue-router'
import MainPage from '@/components/MainPage'
import CatalogPage from '@/components/CatalogPage'
import ArticlePage from '@/components/ArticlePage'
import LoginPage from '@/components/LoginPage'

Vue.use(Router)

export default new Router({
  mode: 'history',
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
      path: '/catalog/',
      name: 'CatalogPage',
      component: CatalogPage
    }
  ]
})
