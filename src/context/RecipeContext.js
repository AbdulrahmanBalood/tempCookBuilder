import { createContext, useState } from 'react';

const RecipeContext = createContext();

export const RecipeProvider = ({ children }) => {
    const [searchUrl,setSearchUrl] = useState('')
    const getSearchUrl = (url) => {
        setSearchUrl(url)
    }
    console.log(searchUrl);
  return (
    <RecipeContext.Provider
      value={{searchUrl,setSearchUrl}}
    >
      {children}
    </RecipeContext.Provider>
  );
};

export default RecipeContext;