# navigation app

Dette projekt er et Android‑app‑projekt udviklet i Kotlin med Jetpack Compose. Her får du en hurtig introduktion til, hvordan projektet er organiseret, så du nemt kan finde rundt og komme i gang med at udvikle.



Components = Hvis man gerne ville lave knapper og små ikoner, så ville man typisk lægge det under components

Model = Så er det primært ideen at den indeholder data-rene klasser, altså de objekter, der beskriver jeres domæne

Navigation = Navigation‑mappen indeholder vores NavGraph og ruterne mellem skærmene. Vi har valgt at samle navigation ét sted for at skabe overblik

Screen = Screen mappen indeholder UI-laget, altså alt det brugeren ser og interagerer med. Man ville typisk sætte en composable pr skærm og kun UI, ingen logik 

UI-theme = UI theme mappen indeholder hele appens visuelle identitet

Viewmodel = ViewModel‑mappen indeholder al logik og state, som UI‑skærmene skal bruge.

MainActivity = Her ligger alt det basale, som får med når man starter en empty activity.


com.example.navigation app

1 -- componenets ⬇️

CustomButton.kt

2 -- model ⬇️

Meditation.kt

3 -- navigation ⬇️

NavGraph.kt

4 -- screen ⬇️

HomeScreen.kt

BreathingExerciseScreen.kt

MeditationDetailsScreen.kt

SelectMeditationScreen.kt

5 -- ui theme ⬇️

Color.kt
Theme.kt
Type.kt

6 -- viewmodel ⬇️

MeditationViewModel.kt

MainActivity

___________________________

Har du lyst til at bidrage?
Hvis du vil lave en ny feature:
1. Lav en ny branch
2. Tilføj dine ændringer
3. Commit og push
4. Lav et Pull Request
5. Få det godkendt af mindst én fra gruppen
6. Merge til main
   
Det sikrer, at alle arbejder struktureret og undgår konflikter.
