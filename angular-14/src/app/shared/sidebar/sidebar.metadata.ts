// Sidebar route metadata
export interface RouteInfo {
  path: string;
  title: string;
  icon: string;
  class: string;
  data: any;
  extralink: boolean;
  submenu: RouteInfo[];
}
