import { createContext, useEffect, useState } from 'react';

const RecipeContext = createContext();

export const RecipeProvider = ({ children }) => {
    const [searchUrl,setSearchUrl] = useState('')
    const[searchType,setSearchType] = useState('')
    const [recipes, setRecipes] = useState([]);
    const [favoriteRecipes,setFavoriteRecipes] = useState([])
    const [favoriteRecipesIDs,setFavoriteRecipesIDs] = useState([])
    const setFavId = () => {

      favoriteRecipes.map((recipe)=> {
        setFavoriteRecipesIDs(recipe.recipeID)
      })
  

}

  return (
    <RecipeContext.Provider
      value={{searchUrl,setSearchUrl,searchType,setSearchType,recipes, setRecipes,favoriteRecipes,setFavoriteRecipes,favoriteRecipesIDs,setFavId}}
    >
      {children}
    </RecipeContext.Provider>
  );
};

export default RecipeContext;