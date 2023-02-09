## Nutritionist \[Adapter pattern \| Factory method\]

#### Description

Module Nutritionist is a simple implementation of the Adapter pattern. This is one of the most simple
design patterns: it acts as a bridge between two incompatible interfaces.

We have a [`Nutritionist`](src/main/java/clinic/Nutritionist.java) who makes really nice diet plans
adjusting calories considering the patient weight. He uses a program that requires to fill some
patient information, including their current weight, and it needs to be **in pounds** for the resultant
data to be correct. Sadly, the [`Clinic`](src/main/java/clinic/Clinic.java) doesn't have founds to buy a scale,
so patients must tell their weight.

Everything goes fine as long as the incoming patients are [`imperial units users`](src/main/java/patient/ImperialUnitsUser.java).
The [`Clinic`](src/main/java/clinic/Clinic.java) doesn't want to miss clients ; so once every patient arrives
and is welcomed by the receptionist, they are asked for their
nationality, and then the receptionist invokes the `acceptPatient(Patient patient)` method:

````
private void acceptPatient(Patient patient) {
        if (patient instanceof ImperialUnitsUser imperialUnitsUser) {
            this.nutritionist.setPatient(imperialUnitsUser);
        } else if (patient instanceof MetricUnitsUser metricUnitsUser) {
            this.nutritionist.setPatient(new MetricUsersAdapter(metricUnitsUser));
        }
````

This code is very self-explaining: if the [`Patient`](src/main/java/patient/Patient.java) implements
[`ImperialUnitsUser`](src/main/java/patient/ImperialUnitsUser.java) interface, the receptionist immediately
redirects the patient to the doctor; otherwise, if we have a patient from a country where people are
[`metric unit users`](src/main/java/patient/MetricUnitsUser.java), we have to «disguise» or adapt the patient
with the [`MetricUserAdapter`](src/main/java/adapter/MetricUserAdapter.java). This class acts as
a translator between the two interfaces, implementing the one the [`Nutritionist`](src/main/java/clinic/Nutritionist.java)
can handle –[`ImperialUnitsUser`](src/main/java/patient/ImperialUnitsUser.java)– for him to be able to admit the patient; and
implementing the `getWeightInPounds()` method applying the necessary conversion factor between kilograms
–which is the unit for metric users– and pounds. That's how the [`Nutritionist`](src/main/java/clinic/Nutritionist.java)
can always call the same method over every patient and tell their weigh in the same unit, no matter where
they come from.

About the **Factory method**, it is a creation design pattern that «hides» the details of instantiating an object
and makes easier to read the code. In this sample use, we get to instantiate patients through the
[`PatientFactory`](src/main/java/utils/PatientFactory.java) static `getPatient` static method. Although
creating a [`Patient`](src/main/java/patient/Patient.java) would requiere to make use of a `CountryCode`
object, we want to abstract this task from that programmer; and also make it even lenient about the country
codes, accepting either ISO 3166-1 alfa-2 and alfa-3 values and adding a default value just in case the
country is not provided –imagine the client doesn't feel comfortable giving that information–. This, of course,
could be expandable in cases the initialization requieres to configure some dependencies of the object invoking
various methods.

#### Subjects, technologies and contents

- Single Responsibility Principle (S from SOLID).
- Open/Closed principle (O from SOLID).
- Use of the com.neovisionaries.i18n library to work with ISO 3166-1 country codes may be of interest.