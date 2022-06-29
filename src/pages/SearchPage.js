import { useState, useEffect ,useContext} from 'react';
import {
  ChakraProvider,
  Box,
  Text,
  Input,
  VStack,
  HStack,
  Code,
  Grid,
  theme,
  Flex,
  Image,
  GridItem,
  Container,
  Button,
  Select,
} from '@chakra-ui/react';
import { AddIcon } from '@chakra-ui/icons';
import { useNavigate  } from "react-router-dom";
import RecipeContext from '../context/RecipeContext';

export const SearchPage = () => {
    const Navigate = useNavigate()
    const {setSearchType,setSearchUrl} = useContext(RecipeContext)
  const [seacrhOption, setSearchOption] = useState('');
  const [optionByIngredient, setOptionByIngredient] = useState(false);
  const [optionByNutrients, setOptionByNutrients] = useState(false);
  const [optionByCuisine, setOptionByCuisine] = useState(false);
  const [ingredients, setIngredients] = useState([{ ingredient: '' }]);
  const [cuisine, setCuisine] = useState('');
  useEffect(() => {
    if (seacrhOption !== '') {
      if (seacrhOption === 'byIngredient') {
        setOptionByIngredient(true);
        setOptionByNutrients(false);
        setOptionByCuisine(false);
      } else if (seacrhOption === 'byNutrients') {
        setOptionByNutrients(true);
        setOptionByIngredient(false);
        setOptionByCuisine(false);
      } else {
        setOptionByCuisine(true);
        setOptionByNutrients(false);
        setOptionByIngredient(false);
      }
    }
  }, [seacrhOption]);

  const onClickByIngredient = () => {
    let url =
      '/api/v1/recipe/recipes/findbyingredients';
    let query = `${ingredients[0]}`;
    if (ingredients.length > 1) {
      for (let i = 1; i < ingredients.length; i++) {
        query += `&ingredients=${ingredients[i]}`;
      }
    }
    let ingUrl =
      url +
      '?ingredients=' +
      query
    setSearchUrl(ingUrl)
    setSearchType("ByIngredient")
    Navigate('/result')
  };
  const onClickByCusine = () => {
    let getByCuisineURL =
      '/api/v1/recipe/recipes/findbycuisine/' +
      cuisine;
    setSearchUrl(getByCuisineURL)
    setSearchType("ByCusine")
    Navigate('/result')
  };
  const cusineOnChange = e => {
    setCuisine(e.target.value);
    console.log(cuisine);
  };
  const handleChange = (index, e) => {
    let data = [...ingredients];
    data[index] = e.target.value;
    setIngredients(data);
  };
  const addFields = () => {
    let newfield = { ingredient: '' };
    setIngredients([...ingredients, newfield]);
  };
  const removeFields = index => {
    let data = [...ingredients];
    data.splice(index, 1);
    setIngredients(data);
  };
  return (
    <Container maxWidth={'3xl'} height="100vh">
      <Flex justifyContent={'center'} alignItems="center">
        <Text fontSize={'4xl'} justifyContent={'center'} alignItems="center">
          Search
        </Text>
      </Flex>
      <Select
        onChange={e => {
          setSearchOption(e.target.value);
        }}
        placeholder="Select option"
      >
        <option value="byIngredient">Search by Ingredient</option>
        <option value="byNutrients">Search by Nutrients</option>
        <option value="byCuisine">Search by Cuisine</option>
      </Select>
      <>
        {(() => {
          if (optionByIngredient) {
            return (
              <div>
                {ingredients.map((ing, index) => {
                  return (
                    <div key={index}>
                      <Input
                        value={ing.ingredient}
                        onChange={e => handleChange(index, e)}
                        marginY={'0.5rem'}
                        placeholder="Search"
                        width={'90%'}
                        size="lg"
                      />
                      <Button
                        onClick={addFields}
                        marginX={'3px'}
                        colorScheme="green"
                      >
                        <AddIcon w={3} h={3} />
                      </Button>
                      <Button
                        colorScheme="red"
                        onClick={() => removeFields(index)}
                      >
                        Remove
                      </Button>
                    </div>
                  );
                })}
                <Flex justifyContent={'center'} alignItems="center">
                  <Button onClick={onClickByIngredient} colorScheme="green">
                    optionByIngredient
                  </Button>
                </Flex>
              </div>
            );
          }
          if (optionByNutrients) {
            return <Text>optionByNutrients</Text>;
          }
          if (optionByCuisine) {
            return (
              <>
                <Input
                  onChange={cusineOnChange}
                  marginY={'0.5rem'}
                  placeholder="Search"
                  size="lg"
                />
                <Flex justifyContent={'center'} alignItems="center">
                  <Button onClick={onClickByCusine} colorScheme="green">
                    optionByCuisine
                  </Button>
                </Flex>
              </>
            );
          }
        })()}
      </>
    </Container>
  );
};
