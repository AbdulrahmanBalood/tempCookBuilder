import React from 'react'
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
  } from '@chakra-ui/react';
  import { Navigate, useNavigate ,Link} from 'react-router-dom';

export const NavLinkComp = ({children,toValue}) => {
  return (
    <Link
    px={2}
    py={1}
    rounded={'md'}
    _hover={{
      textDecoration: 'none',
      bg: useColorModeValue('green.300'),
    }}
    to={toValue}>
    {children}
  </Link>
  )
}
