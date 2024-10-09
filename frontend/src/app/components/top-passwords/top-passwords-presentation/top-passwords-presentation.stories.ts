import type { Meta, StoryObj } from "@storybook/angular";
import {TopPasswordsPresentationComponent} from "./top-passwords-presentation.component";
import {TopPasswordsPresentation} from "./top-passwords-presentation.interface";
import {of} from "rxjs";



// story meta config
const meta: Meta<TopPasswordsPresentationComponent> = {
  title: "TopPasswordsPresentation",
  component: TopPasswordsPresentationComponent
};
export default meta;


// mocks
const userMock: TopPasswordsPresentation = {
  passwords: of([{
    password: "123456",
    count: 5
  }])
};


// stories
type TopPasswordsPresentationStory = StoryObj<TopPasswordsPresentationComponent>;


export const primary: TopPasswordsPresentationStory = {
  args: {
    topPasswords: userMock
  }
};
