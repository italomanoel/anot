/**O [SecurityManager] está depreciado, funcinal antes do java 8. Deve analisar a função abaixo, onde mesmo com o método [doPrivileged] também depreciado ainda não foi removido até o java versão 22.*/
import java.security.AccessController;
import java.security.PrivilegedAction;
// import java.security.*;
// public class BomDia {

//     public static void main(String[] args) {
//         try {
//             /**obter permissão de sistema com privilégios elevados*/
//             SecurityManager securityManager = System.getSecurityManager();
//             if (securityManager != null) {
//                 securityManager.checkPermission(new RuntimePermission("accessClassInPackage.sun.*"));
//                 System.out.println("Bom dia! Privilégio administrativo.");
//             } else {
//                 System.out.println("Bom dia! Sem permissões administrativas.");
//             }
//         } catch (AccessControlException e) {
//             System.out.println("Bom dia! Erro, obter permissões administrativas foi negado.");
//         }
//     }
// }
public class BomDia {
  
    public static void main(String[] args) {
        boolean hasAdminPrivileges = AccessController.doPrivileged(new PrivilegedAction<Boolean>() {
            public Boolean run() {
                try {
                    // Tentativa de carregar uma classe do pacote sun.*
                    Class.forName("sun.misc.Unsafe");
                    return true;
                } catch (ClassNotFoundException e) {
                    return false;
                }
            }
        });

        if (hasAdminPrivileges) {
            System.out.println("Bom dia! Você tem permissões administrativas.");
        } else {
            System.out.println("Bom dia! Você não tem permissões administrativas.");
        }
    }
}
