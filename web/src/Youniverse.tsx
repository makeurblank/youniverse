import React from "react"

interface Props {
    id?: number;
    className?: string;
    children?: React.ReactNode;
}


export default function Youniverse(props: Props): JSX.Element {
    const {
        id,
        className,
        children
    } = props;

    const defaultKeys = [
        'id',
        'className',
        'children'
    ];

    return (
        <Youniverse 
            id={id}
            class={className}
        >
            {children}
        </Youniverse>
    );
}