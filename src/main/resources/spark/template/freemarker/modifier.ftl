<html>

	<form action="/resultat" method="get">
	
		<select name="Action">
		<option value = "Ajouter"> Ajouter </option> 
		<option value = "Lire"> Lire </option>
		<option value = "Mettre_a_jour"> Mettre a jour </option>
		<option value = "Supprimer"> Supprimer </option>
		</select>
		<br></br>
	
		<select name="civilite">
		<option value = "Mr"> Mr </option> 
		<option value = "Mme"> Mme </option>
		<option value = "Mlle"> Mlle </option>
		<option value = "-"> - </option>
		</select>
		<br></br>
	
		Nom : <input type="text" name="nom">	
		<br></br>
		
		Prenom : <input type="text" name="prenom">	
		<br></br>
		
		Identifiant : <input type="text" name="Id">	
		<br></br>
		
		<button type="submit">Valider !</button>
	
	</form>


</html>