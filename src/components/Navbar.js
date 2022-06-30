import {
  Box,
  Flex,
  Avatar,
  HStack,
  IconButton,
  Button,
  Menu,
  MenuButton,
  MenuList,
  MenuItem,
  MenuDivider,
  useDisclosure,
  useColorModeValue,
  Stack,
  Text
} from '@chakra-ui/react';
import React, { useContext } from 'react';
import { NavLinkComp } from './NavLinkComp';
import { HamburgerIcon, CloseIcon } from '@chakra-ui/icons';
import profile from '../images/profile.png'
import AuthContext from '../context/AuthContext';
import { Navigate, useNavigate ,Link} from 'react-router-dom';

export const Navbar = () => {
  const Navigate = useNavigate();
  const Links = [{lable:'Search',value:"/search"}];
  const { isOpen, onOpen, onClose } = useDisclosure();
  const { logout, removeIsLogged,isLogged } = useContext(AuthContext);
  let menuListItems = ()=> {
    if(isLogged){
      return(
        <>
  <MenuItem onClick={()=> {
    Navigate("/profile")
  }}>Profile</MenuItem>
  <MenuDivider />
  <MenuItem onClick={()=> {
    const isLoggedOut = logout()
    if(isLoggedOut){
      removeIsLogged();
      Navigate('/')
    }
  }}>Logout</MenuItem>
        </>
      )
    }else {
      return(
      <>
  <MenuItem onClick={()=> {
     Navigate('/login')
  }}>Login</MenuItem>
  <MenuItem  onClick={()=> {
     Navigate('/register')
  }}>Register</MenuItem>
      </>)
    }
  }
  return (
    <>
      <Box bg={useColorModeValue('green.400')} px={4}>
        <Flex h={16} alignItems={'center'} justifyContent={'space-between'}>
          <IconButton
            colorScheme={'green.400'}
            color="white"
            size={'md'}
            icon={isOpen ? <CloseIcon /> : <HamburgerIcon />}
            aria-label={'Open Menu'}
            display={{ md: 'none' }}
            onClick={isOpen ? onClose : onOpen}
          />
          <HStack spacing={8} alignItems={'center'}>
            <Link to={'/'}>
              <Box color={'white'}>CookBuilder</Box>
            </Link>
            <HStack
              backgroundColor={'green.400'}
              color="white"
              as={'nav'}
              spacing={4}
              display={{ base: 'none', md: 'flex' }}
            >

              {Links.map((link,index) => (
                <NavLinkComp toValue = {link.value} key={index}>{link.lable}</NavLinkComp>
              ))}
            </HStack>
          </HStack>
          <Flex alignItems={'center'}>
            <Menu>
              <MenuButton
                as={Button}
                rounded={'full'}
                variant={'link'}
                cursor={'pointer'}
                minW={0}
              >
                <Avatar
                  size={'sm'}
                  backgroundColor="green.400"
                  src={
                    profile
                  }
                />
              </MenuButton>
              <MenuList>
    
                <>
                {menuListItems()}
                </>

                
              </MenuList>
            </Menu>
          </Flex>
        </Flex>

        {isOpen ? (
          <Box pb={4} display={{ md: 'none' }}>
            <Stack color={'white'} as={'nav'} spacing={4}>
              {Links.map((link,index) => (
                  <NavLinkComp toValue = {link.value} key={index}>{link.lable}</NavLinkComp>
              ))}
            </Stack>
          </Box>
        ) : null}
      </Box>
    </>
  );
};
