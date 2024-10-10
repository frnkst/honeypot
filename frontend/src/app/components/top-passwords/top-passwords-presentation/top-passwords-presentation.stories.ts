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

const mockInput: TopPasswordsPresentation = {
  passwords: of([{
    password: "admin",
    count: 504
  }, {
    password: "1234",
    count: 302
  }, {
    password: "root",
    count: 201
  }, {
    password: "test",
    count: 200
  }, {
    password: "hello",
    count: 13
  }])
};

type TopPasswordsPresentationStory = StoryObj<TopPasswordsPresentationComponent>;

export const Default: TopPasswordsPresentationStory = {
  args: {
    topPasswords: mockInput
  }
};
