import { RouteInfo } from './sidebar.metadata';

export const ROUTES: RouteInfo[] = [
 
  {
    path: '/dashboard',
    title: 'Tableau de bord',
    icon: 'bi bi-speedometer2',
    class: '',
    data: [],
    extralink: false,
    submenu: [],
  },
  {
    path:  '/component/cardEmploi',//'/component/alert',
    title: 'Emploi du temps',
    icon: 'bi bi-bell',
    class: '',
    data: [],
    extralink: false,
    submenu: []
  },
  // {
  //   path: '/about',
  //   title: 'Absence',
  //   icon: 'bi bi-card-text',
  //   class: '',
  //   data: [],
  //   extralink: false,
  //   submenu: []
  // },
  {
    path: '/component/table',
    title: 'Stagiaire',
    icon: 'bi bi-layout-split',
    class: '',
    data: [],
    extralink: false,
    submenu: []
  },
  {
    path: '/component/card',
    title: 'Feuille emargement',
    icon: 'bi bi-people',
    class: '',
    data: [],
    extralink: false,
    submenu: []
  }
];
