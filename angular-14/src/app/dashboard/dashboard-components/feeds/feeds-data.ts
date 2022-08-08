export interface Feed {
    class: string,
    icon: string,
    task: string,
    time: string
}

export const Feeds: Feed[] = [

    {
        class: 'bg-info',
        icon: 'bi bi-bell',
        task: 'Tache numéro 01',
        time: 'Maintenant'
    },
    {
        class: 'bg-success',
        icon: 'bi bi-hdd',
        task: 'Tache numéro 02',
        time: '2 Heure'
    },
    {
        class: 'bg-warning',
        icon: 'bi bi-bag-check',
        task: 'Tache numéro 03',
        time: '31 mai'
    },
    {
        class: 'bg-danger',
        icon: 'bi bi-person',
        task: 'Tache numéro 04',
        time: '30 mai'
    },
    {
        class: 'bg-primary',
        icon: 'bi bi-person',
        task: 'Tache numéro 05',
        time: '21 mai'
    },

] 