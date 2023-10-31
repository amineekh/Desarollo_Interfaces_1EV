package Tablas;

import javax.swing.table.AbstractTableModel;

public class StudentTableModel extends AbstractTableModel {

    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public int getColumnCount() {
        return 0;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
    }

    private enum StudentTableColumns {
// Aquí defino todas las columnas

        Nif("NIF"),

        Name("Nombre"),

        Surname("Apellidos"),

        Age("Edad");
// Estos son los campos de cada columna

        final String header;

        StudentTableColumns(String header) {
            this.header = header;
        }

    }
}
