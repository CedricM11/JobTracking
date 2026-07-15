import { createRouter, createWebHistory, type RouteRecordRaw } from 'vue-router'

const routes: Array<RouteRecordRaw> = [
	{ path: '/', name: 'home', component: () => import('@/views/HomeView.vue') },
	{ path: '/new', name: 'new', component: () => import('@/views/NewApplicationView.vue') },
	{ path: '/edit/:id', name: 'edit', component: () => import('@/views/EditApplicationView.vue'), props: true },
	{ path: '/:pathMatch(.*)*', name: 'notFound', component: () => import('@/views/NotFoundView.vue') },
]

const router = createRouter({
	history: createWebHistory(import.meta.env.BASE_URL),
	routes,
})

export default router
