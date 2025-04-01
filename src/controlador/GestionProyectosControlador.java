package controlador;

import modelo.*;
import utilidades.FuncionesFechas;
import vista.GestionProyectosVista;
import vista.GestionUsuariosVista;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Arrays;

public class GestionProyectosControlador {
    private GestionProyectos modelo;
    private GestionProyectosVista vista;

    public GestionProyectosControlador(GestionProyectos modelo, GestionProyectosVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void mostrarMensaje(String colorTexto, String mensaje) {
        vista.setColorTexto(colorTexto);
        vista.mostrarMensaje(mensaje);
    }

    public void agregarProyecto(Proyecto proyecto) {
        Proyecto proyectoAgregado = modelo.agregarProyecto(proyecto);
        if (proyectoAgregado != null) {
            mostrarMensaje(GestionProyectosVista.VERDE, "Proyecto agregado con éxito: " + proyecto);
        } else {
            mostrarMensaje(GestionProyectosVista.ROJO, "No se pudo agregar el proyecto: el proyecto no existe");
        }
    }

    public Proyecto buscarProyecto(int posicion) {
        Proyecto proyectoBuscado = modelo.buscarProyecto(posicion);
        if (proyectoBuscado != null) {
            mostrarMensaje(GestionProyectosVista.VERDE, "Proyecto encontrado en la posición " + posicion + ": " + proyectoBuscado);
        } else {
            mostrarMensaje(GestionProyectosVista.ROJO, "No se pudo encontrar el proyecto: no hay nada en la posición " + posicion);
        }
        return proyectoBuscado;
    }

    public int buscarPosicion(int idProyecto) {
        int posicionProyecto = modelo.buscarPosicion(idProyecto);
        if (posicionProyecto != -1) {
            mostrarMensaje(GestionProyectosVista.VERDE, "La posición del proyecto con ID " + idProyecto + " es: " + posicionProyecto);
        } else {
            mostrarMensaje(GestionProyectosVista.ROJO, "No se pudo encontrar la posición: el proyecto con ID " + idProyecto + " no existe.");
        }
        return posicionProyecto;
    }

    public int buscarPosicion(Proyecto proyecto) {
        int posicionProyecto = modelo.buscarPosicion(proyecto);
        if (posicionProyecto != -1) {
            mostrarMensaje(GestionProyectosVista.VERDE, "La posición del proyecto " + proyecto.getNombre() + " es: " + posicionProyecto);
        } else {
            mostrarMensaje(GestionProyectosVista.ROJO, "No se pudo encontrar la posición: el proyecto " + proyecto.getNombre() + " no existe.");
        }
        return posicionProyecto;
    }

    /**
     * Método para modificar un proyecto.
     * @param proyecto El proyecto a modificar.
     * @param atributo El nombre del atributo a modificar (por ejemplo: "nombre", "descripcion", "fechainicio", etc.)
     * @param valor El nuevo valor en formato String.
     */
    public void modificarProyecto(Proyecto proyecto, String atributo, String valor) {
        try {
            switch (atributo.toLowerCase().trim()) {
                case "nombre" -> {
                    if (valor != null && !valor.trim().isEmpty()) {
                        proyecto.setNombre(valor.trim());
                        mostrarMensaje(GestionProyectosVista.VERDE,"Nombre modificado correctamente.");
                    } else {
                        mostrarMensaje(GestionProyectosVista.ROJO,"El valor para 'nombre' es inválido.");
                    }
                }

                case "descripcion" -> {
                    if (valor != null && !valor.trim().isEmpty()) {
                        proyecto.setDescripcion(valor.trim());
                        mostrarMensaje(GestionProyectosVista.VERDE,"Descripción modificada correctamente.");
                    } else {
                        mostrarMensaje(GestionProyectosVista.ROJO,"El valor para 'descripcion' es inválido.");
                    }
                }

                case "categoria" -> {
                    Categoria categoria = modelo.getCategoria(valor);
                    if (categoria != null) {
                        proyecto.setCategoria(categoria);
                        mostrarMensaje(GestionProyectosVista.VERDE,"Categoría modificada correctamente.");
                    } else {
                        mostrarMensaje(GestionProyectosVista.ROJO,"El valor para 'categoria' es inválido. Debe ser uno de: " + Arrays.toString(Categoria.values()));
                    }
                }

                case "fechainicio" -> {
                    LocalDate fechaInicio = FuncionesFechas.parsearFecha(valor.trim());
                    proyecto.setFechaInicio(fechaInicio);
                    mostrarMensaje(GestionProyectosVista.VERDE,"Fecha de inicio modificada correctamente.");
                }

                case "fechafin" -> {
                    LocalDate fechaFin = FuncionesFechas.parsearFecha(valor);
                    proyecto.setFechaFin(fechaFin);
                    mostrarMensaje(GestionProyectosVista.VERDE,"Fecha de fin modificada correctamente.");
                }


                case "cantidadnecesaria" -> {
                    float cantidadNecesaria = Float.parseFloat(valor.trim());
                    proyecto.setCantidadNecesaria(cantidadNecesaria);
                    mostrarMensaje(GestionProyectosVista.VERDE,"Cantidad necesaria modificada correctamente.");
                }

                case "cantidadfinanciada" -> {
                    float cantidadFinanciada = Float.parseFloat(valor.trim());
                    proyecto.setCantidadFinanciada(cantidadFinanciada);
                    mostrarMensaje(GestionProyectosVista.VERDE,"Cantidad financiada modificada correctamente.");
                }

                case "listarecompensas" -> mostrarMensaje(GestionProyectosVista.ROJO,"La lista de recompensas no se puede modificar directamente mediante este método.");

                case "listainversiones" -> mostrarMensaje(GestionProyectosVista.ROJO,"La lista de inversiones no se puede modificar directamente mediante este método.");

                default -> mostrarMensaje(GestionProyectosVista.ROJO,"Atributo no reconocido.");

            }
        } catch (NumberFormatException e) {
            mostrarMensaje(GestionProyectosVista.ROJO,"Error de conversión numérica: " + e.getMessage());
        } catch (DateTimeParseException e) {
            mostrarMensaje(GestionProyectosVista.ROJO,"Error en el formato de fecha (se espera dd/MM/yyyy): " + e.getMessage());
        } catch (Exception e) {
            mostrarMensaje(GestionProyectosVista.ROJO,"Error al modificar el proyecto: " + e.getMessage());
        }
    }

    public void modificarProyecto(int posicion, Proyecto proyecto) {
        Proyecto proyectoModificado = modelo.modificaProyecto(posicion, proyecto);
        if (proyectoModificado != null) {
            mostrarMensaje(GestionProyectosVista.VERDE, "Proyecto modificado con éxito: " + proyectoModificado);
        } else {
            mostrarMensaje(GestionProyectosVista.ROJO, "No se pudo modificar el proyecto: no hay ningún proyecto en la posición: " + posicion);
        }
    }

    public void eliminarProyecto(int posicion) {
        Proyecto proyectoEliminado = modelo.eliminarProyecto(posicion);
        if (proyectoEliminado != null) {
            mostrarMensaje(GestionProyectosVista.VERDE, "Proyecto eliminado con éxito: " + proyectoEliminado);
        } else {
            mostrarMensaje(GestionProyectosVista.ROJO, "No se pudo eliminar el proyecto: no hay ningún proyecto en la posición: " + posicion);
        }
    }

    public void eliminarProyecto(Proyecto proyecto) {
        Proyecto proyectoEliminado = modelo.eliminarProyecto(proyecto);
        if (proyectoEliminado != null) {
            mostrarMensaje(GestionProyectosVista.VERDE, "Proyecto eliminado con éxito: " + proyectoEliminado);
        } else {
            mostrarMensaje(GestionProyectosVista.ROJO, "No se pudo eliminar el proyecto: el proyecto no existe.");
        }
    }

    public void eliminarProyectoGestor(Gestor gestor, int posicion) {
        Proyecto proyectoEliminado = modelo.eliminarProyectoGestor(gestor, posicion);
        if (proyectoEliminado != null) {
            mostrarMensaje(GestionProyectosVista.VERDE, "Proyecto eliminado con éxito: " + proyectoEliminado);
        } else {
            mostrarMensaje(GestionProyectosVista.ROJO, "No se pudo eliminar el proyecto: el proyecto no existe.");
        }
    }

    public Categoria getCategoria(String categoria) {
        if (modelo.getCategoria(categoria) != null) {
            mostrarMensaje(GestionProyectosVista.VERDE, "Categoría añadida con éxito.");
            return modelo.getCategoria(categoria);
        } else {
            mostrarMensaje(GestionUsuariosVista.ROJO, "No se pudo añadir la categoría: no existe.");
            return null;
        }
    }

    public void agregarRecompensa(Proyecto proyecto, Recompensa recompensa) {
        if (proyecto != null && recompensa != null) {
            modelo.agregarRecompensa(proyecto, recompensa);
            mostrarMensaje(GestionProyectosVista.VERDE, "Recompensa añadida con éxito.");
        } else {
            mostrarMensaje(GestionUsuariosVista.ROJO, "No se pudo añadir la recompensa: el proyecto y/o la recompensa no existen.");
        }
    }

    /**
     * Método para modificar una recompensa de un proyecto.
     * @param proyecto El proyecto que contiene la recompensa.
     * @param indice El índice de la recompensa en el ArrayList (0, 1 o 2).
     * @param atributo El nombre del atributo a modificar ("descripcion" o "precio").
     * @param valor El nuevo valor en formato String.
     */
    public void modificarRecompensa(Proyecto proyecto, int indice, String atributo, String valor) {
        // Verificar que el ArrayList de recompensas existe y contiene elementos
        if (proyecto.getListaRecompensas() == null || proyecto.getListaRecompensas().isEmpty()) {
            mostrarMensaje(GestionUsuariosVista.ROJO,"No hay recompensas en este proyecto.");
            return;
        }
        // Validar que el índice es correcto
        if (indice < 0 || indice >= proyecto.getListaRecompensas().size()) {
            mostrarMensaje(GestionUsuariosVista.ROJO,"Índice de recompensa inválido.");
            return;
        }

        // Obtener la recompensa correspondiente
        Recompensa recompensa = proyecto.getListaRecompensas().get(indice);

        // Convertir el atributo a minúsculas para evitar problemas de mayúsculas
        switch (atributo.toLowerCase().trim()) {
            case "descripcion" -> {
                if (valor != null && !valor.trim().isEmpty()) {
                    recompensa.setDescripcion(valor.trim());
                    mostrarMensaje(GestionUsuariosVista.VERDE, "Descripción de la recompensa modificada correctamente.");
                } else {
                    mostrarMensaje(GestionUsuariosVista.ROJO, "El valor para la descripción es inválido.");
                }
            }

            case "precio" -> {
                try {
                    float precio = Float.parseFloat(valor.trim());
                    // Validación adicional: el precio no debe ser negativo
                    if (precio < 0) {
                        mostrarMensaje(GestionUsuariosVista.ROJO, "El precio no puede ser negativo.");
                        return;
                    }
                    recompensa.setPrecio(precio);
                    mostrarMensaje(GestionUsuariosVista.VERDE,"Precio de la recompensa modificado correctamente.");
                } catch (NumberFormatException e) {
                    mostrarMensaje(GestionUsuariosVista.ROJO,"Formato numérico incorrecto para el precio: " + e.getMessage());
                }
            }

            default -> mostrarMensaje(GestionUsuariosVista.ROJO,"Atributo de recompensa no reconocido.");
        }
    }


    public void mostrarTotalProyectos() {
        if (!modelo.getListaProyectos().isEmpty()) {
            vista.mostrarProyectos(modelo.getListaProyectos());
        } else {
            mostrarMensaje(GestionUsuariosVista.ROJO, "No hay ningún proyecto registrado.");
        }
    }

    public void mostrarProyectosGestor(Gestor gestor) {
        if (!gestor.getListaProyectos().isEmpty()) {
            vista.mostrarProyectos(gestor.getListaProyectos());
        } else {
            mostrarMensaje(GestionUsuariosVista.ROJO, "No has creado ningún proyecto.");
        }
    }

    public void mostrarVistaDetallada(Proyecto proyecto) {
        vista.vistaDetalladaProyecto(proyecto);
    }
}
