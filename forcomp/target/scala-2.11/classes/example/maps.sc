val capitalOfCountry = Map ("US"-> "Washington", "Switzerland" -> "Bern")

capitalOfCountry ("Japan")
capitalOfCountry get "Japan"
capitalOfCountry get "US"

def showCapital (country : String ) = capitalOfCountry get country match {
  case Some(capital) => capital
  case None => "Missing data"
}

showCapital("Japan")

val capDefault = capitalOfCountry withDefaultValue  "Unknown"

capDefault("Japan")

 
