## EJEMPLO DE PATRÓN ADAPTER

La clase «others.Nutritionist» admite como parámetro cualquier objeto que implemente la interfaz «ImperialUnitsUser», ya que únicamente es capaz de tratar pacientes midiendo su peso en libras.

Para poder ayudar a un paciente que implemente la interfaz «MetricUnitsUser», la admisión de pacientes de la clínica –clase «others.Clinic»– se apoya en la clase auxiliar «others.MetricUsersAdapter».

* Uso del patrón **Factory Method** para la obtención de pacientes.
