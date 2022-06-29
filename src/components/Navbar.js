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
import { NavLinkComp } from './NavLinkComp';
import { HamburgerIcon, CloseIcon } from '@chakra-ui/icons';
import { Link } from 'react-router-dom';
import profile from '../images/profile.png'

export const Navbar = () => {
  const Links = [{lable:'Search',value:"/search"}];
  const { isOpen, onOpen, onClose } = useDisclosure();
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
                {/* Navigate here  and conditional*/}
                {/* //////////////////////////////////////////////////////////////////////// */}
                <MenuItem>Settings</MenuItem>
                <MenuItem>Profile</MenuItem>
                <MenuDivider />
                <MenuItem>Logout</MenuItem>
              </MenuList>
            </Menu>
          </Flex>
        </Flex>

        {isOpen ? (
          <Box pb={4} display={{ md: 'none' }}>
            <Stack color={'white'} as={'nav'} spacing={4}>
              {Links.map(link => (
                <NavLinkComp key={link}>{link}</NavLinkComp>
              ))}
            </Stack>
          </Box>
        ) : null}
      </Box>
    </>
  );
};
