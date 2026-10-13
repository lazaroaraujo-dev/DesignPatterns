public class Main {
    public static void main(String[] args) {
        ControleUniversal tvsamsumg = new SamsungAdapter(new TvSamungApi());
        MiRemoteApp app1 = new MiRemoteApp(tvsamsumg);
        app1.iniciar();
        app1.encerrar();

        System.out.println();

        ControleUniversal tvlg = new LgAdapter(new TvLgApi());
        MiRemoteApp app2 = new MiRemoteApp(tvlg);
        app2.iniciar();
        app2.encerrar();

        System.out.println();
        ControleUniversal arCondicionado = new ArCondicionadoAdapter(new ArCondicionadoApi());
        MiRemoteApp app3 = new MiRemoteApp(arCondicionado);
        app3.iniciar();
        app3.encerrar();
    }
}