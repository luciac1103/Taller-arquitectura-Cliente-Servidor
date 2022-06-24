package co.unicauca.travelagency.cliente;

import co.unicauca.travelagency.domain.entity.Customer;

/**
 *
 * @author eri-k
 */
public class ClienteMain {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // CREANDO UN CLIENTE
        NewJerseyClient jersey = new NewJerseyClient();
        String rta = jersey.create_JSON(new Customer("98000012", "Sebastian", "Arango", 
                "Calle 8 No 11-14 Popayan", "3154786950", "sebasar@hotmail.com", "Masculino"));
        System.out.println("Resultado creación cliente");
        System.out.println("Rta " + rta);
        System.out.println("");
        // BUSCANDO UN CLIENTE
        Customer cust2 = jersey.findById(Customer.class, "98000004");
        System.out.println("Resultado búsqueda de cliente");
        System.out.println("Id: "+cust2.getId());
        System.out.println("Nombre: "+cust2.getFirstName());
        System.out.println("Apellido: "+cust2.getLastName());
        System.out.println("Dirección: "+cust2.getAddress());
        System.out.println("Telefono movil: "+cust2.getMobile());
        System.out.println("Email: "+cust2.getEmail());
        System.out.println("Género: "+cust2.getGender());
        System.out.println("");
        
        //ELIMINAR UN CLIENTE
        Customer cust3 = jersey.findById(Customer.class, "98000009");
        String respuesta = jersey.remove(cust3.getId());
        System.out.println("Resultado eliminacion cliente");
        System.out.println("Rta " + respuesta);
        System.out.println("");
        //EDITAR UN CLIENTE
        Customer cust4 = jersey.findById(Customer.class, "98000004");
        cust4.setFirstName("Juan");
        cust4.setLastName("Perez");
        cust4.setAddress("calle 5 No 8-30");
        cust4.setGender("Masculino");
        cust4.setEmail("juanp@gmail.com");
        cust4.setMobile("3203456786");
        String res = jersey.update_JSON(cust4);
        System.out.println("Resultado actualización cliente");
        System.out.println("Rta " + res);
    }    
}

